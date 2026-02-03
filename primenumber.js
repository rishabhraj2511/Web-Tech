//Check prime number taking value from user
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
rl.question('Enter a number to check if it is prime: ', (input) => {
    const number = parseInt(input);
    if (isNaN(number) || number < 2) {
        console.log('Please enter a valid number greater than 1.');
        rl.close();
        return;
    }
    let isPrime = true;
    for (let i = 2; i <= Math.sqrt(number); i++) {
        if (number % i === 0) {
            isPrime = false;
            break;
        }
    }
    if (isPrime) {
        console.log(`${number} is a prime number.`);
    } else {
        console.log(`${number} is not a prime number.`);
    }
    rl.close();
});