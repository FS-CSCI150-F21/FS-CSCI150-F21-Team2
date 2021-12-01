import os
from time import sleep

from animal_detection import detector as animal_detector
import interactive_terminal.terminal as term
from threading import Thread
from utils.logging import log
import utils.status as us

def main():
	os.system('clear')
	
	animal_det_thread = Thread(target=animal_detector.detection_loop)
	if us.get_animal_detection_status():
		animal_det_thread.start()
		
	sleep(0.5)
	term.terminal_loop()

if __name__ == '__main__':
	main()
