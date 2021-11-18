from enum import Enum

class WarningType(str, Enum):
    ANIMAL_DETECTED = 'animal'
    WATER_LEAK = 'leak'