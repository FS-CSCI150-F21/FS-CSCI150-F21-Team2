from http.server import BaseHTTPRequestHandler, HTTPServer
import logging

import server.connection as sc
import server.json_bodies as body
from utils.logging import log
import utils.status as us
import server.data as sd

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

        try:
            CurServerRequest = self.get_request_body(post_data)
            self.execute_server_request(CurServerRequest)
            self._set_response()
            self.wfile.write("POST request for {}".format(self.path).encode('utf-8'))
            
        except Exception as e:
            self._set_malformed_response(e)
            logging.info(str(e))
        
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
        post_body = {}
        for key, value in zip(keys, values):
            post_body[key] = value

        # convert to object and return
        return body.ServerRequest(**post_body)

    def execute_server_request(self, ServerRequestObj: body.ServerRequest):
        _, uuid = sc.get_registration()
        if uuid != ServerRequestObj.gardenId:
            raise Exception('ERROR: Mismatched gardenId.')

        action = ServerRequestObj.action

        if action == 1:
            us.set_automatic_watering_status(False)
            log('Automatic watering disabled.')
        elif action == 2:
            us.set_automatic_watering_status(True)
            log('Automatic watering enabled.')
        elif action == 3:
            sd.send_current_data()
            log('Current data snapshot sent to server.')
        else:
            raise Exception('ERROR: Invalid action.')


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