from http.server import BaseHTTPRequestHandler, HTTPServer
import logging

import server.connection as sc
import server.json_bodies as body

class S(BaseHTTPRequestHandler):
    def _set_response(self):
        self.send_response(200)
        self.send_header('Content-type', 'text/html')
        self.end_headers()

    def _set_malformed_response(self, msg: Exception):
        self.send_response(400, message=str(msg))
        self.send_header('Content-type', 'text/html')
        self.end_headers()

    def do_GET(self):
        logging.info("GET request,\nPath: %s\nHeaders:\n%s\n", str(self.path), str(self.headers))
        self._set_response()
        self.wfile.write("GET request for {}".format(self.path).encode('utf-8'))

    def do_POST(self):
        content_length = int(self.headers['Content-Length']) # <--- Gets the size of data
        post_data = self.rfile.read(content_length) # <--- Gets the data itself
        logging.info("POST request,\nPath: %s\nHeaders:\n%s\n\nBody:\n%s\n",
                str(self.path), str(self.headers), post_data.decode('utf-8'))

        try:
            CurServerRequest = self.get_body(post_data)
            self._set_response()
            self.wfile.write("POST request for {}".format(self.path).encode('utf-8'))
            
        except Exception as e:
            self._set_malformed_response(e)
            logging.info('POST request malformed.')
        
    def get_request_body(self, response) -> body.ServerRequest:
        # parse POST request for body
        post_body = response.decode()
        post_body = post_body.split('\n')
        # remove unneeded lines
        post_body = [line.strip() for line in post_body if line.strip() != '' and line[0] != '-']
        # get keys from even lines by finding key after = sign
        keys = [post_body[i][post_body[i].find('=')+2:-1] for i in range(0, len(post_body), 2)]
        # get values from odd lines
        values = [post_body[i] for i in range(1, len(post_body), 2)]
        
        for key, value in zip(keys, values):
            post_body[key] = value

        # convert to object and return
        return body.ServerRequest(**post_body)



        

def run(server_class=HTTPServer, handler_class=S, port=8080):
    logging.basicConfig(level=logging.INFO)
    server_address = ('172.22.46.66', port)
    httpd = server_class(server_address, handler_class)
    logging.info('Starting httpd...\n')
    try:
        httpd.serve_forever()
    except KeyboardInterrupt:
        pass
    httpd.server_close()
    logging.info('Stopping httpd...\n')

if __name__ == '__main__':
    from sys import argv

    if len(argv) == 2:
        run(port=int(argv[1]))
    else:
        run()