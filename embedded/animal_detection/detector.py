import tensorflow as tf
import os

def detection_loop(frequency: int = 10000):
    """
    Args:
        frequency: int (default = 10000)
            Frequency of how often system should check for an animal in milliseconds
    """