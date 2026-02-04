import random

def scramble_word(word):
    """This function will take a word and return a scrambled version of it."""
    word_list = list(word)  # Convert the word to a list of characters
    random.shuffle(word_list)  # Shuffle the characters
    return ''.join(word_list)  # Join the list back into a string

def word_scramble_game():
    """The main game function."""
    # List of words to scramble
    words = ['python', 'programming', 'scramble', 'challenge', 'computer']

    # Randomly choose a word from the list
    word_to_guess = random.choice(words)

    # Scramble the word
    scrambled_word = scramble_word(word_to_guess)

    print("Welcome to the Word Scramble Game!")
    print(f"Here is your scrambled word: {scrambled_word}")
    
    attempts = 0  # To count the number of attempts
    guessed_correctly = False
    
    # Keep prompting the user until they guess the word correctly
    while not guessed_correctly:
        guess = input("Guess the word: ").lower()  # Take the user's guess
        
        attempts += 1  # Increment the attempts counter
        
        if guess == word_to_guess:
            guessed_correctly = True  # Set the flag to True when guessed correctly
            print(f"Congratulations! You've guessed the word correctly in {attempts} attempts.")
        else:
            print("Incorrect guess. Try again.")

# Call the game function
word_scramble_game()