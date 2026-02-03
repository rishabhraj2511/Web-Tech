const readline = require("readline");
// create interface
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

// Arrow function calculator
const calculator = () => {
    rl.question("Enter first number: ", (num1) => {
        rl.question("Enter second number: ", (num2) => {
            rl.question("Enter operator (+, -, *, /): ", (operator) => {

                num1 = parseInt(num1);
                num2 = parseInt(num2);
                let result;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;

                    case "*":
                        result = num1 * num2;
                        break;

                    case "/":
                        if (num2 === 0) {
                            console.log("Division by zero not allowed");
                            rl.close();
                            return;
                        }
                        result = num1 / num2;
                        break;

                    default:
                        console.log("Invalid operator");
                        rl.close();
                        return;
                }

                console.log("Result:", result);
                rl.close();
            });
        });
    });
};
calculator();
