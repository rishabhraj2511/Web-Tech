// craete a class and store student information and their marks and print the maximum marks and minimum marks.
class Student {
    constructor(name, marks) {
        this.name = name;
        this.marks = marks; // marks is an array of numbers
    }
    getMaxMarks() {
        return Math.max(...this.marks);
    }
    getMinMarks() {
        return Math.min(...this.marks);
    }
    printDetails() {
        console.log(`Student Name: ${this.name}`);
        console.log(`Marks: ${this.marks.join(', ')}`);
        console.log(`Maximum Marks: ${this.getMaxMarks()}`);
        console.log(`Minimum Marks: ${this.getMinMarks()}`);
    }
}
// Example usage:
const student1 = new Student('Alice', [85, 92, 78, 90, 88]);
student1.printDetails();
const student2 = new Student('Bob', [76, 81, 95, 89, 84]);
student2.printDetails();
const student3 = new Student('Charlie', [90, 91, 92, 93, 94]);
student3.printDetails();
const student4 = new Student('David', [65, 70, 75, 80, 85]);
student4.printDetails();
const student5 = new Student('Eve', [88, 79, 85, 92, 90]);
student5.printDetails();
