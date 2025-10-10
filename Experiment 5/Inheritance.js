class Person {
  constructor(name, age) {
    this.name = name;
    this.age = age;
  }

  introduce() {
    return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
  }

  getRole() {
    return "I am a person.";
  }
}

class Student extends Person {
  constructor(name, age, course) {
    super(name, age);
    this.course = course;
  }

  getRole() {
    return `I am a student studying ${this.course}.`;
  }

  study() {
    return `${this.name} is studying hard for the ${this.course} course.`;
  }
}

class Teacher extends Person {
  constructor(name, age, subject) {
    super(name, age);
    this.subject = subject;
  }

  getRole() {
    return `I am a teacher teaching ${this.subject}.`;
  }

  teach() {
    return `${this.name} is teaching ${this.subject} today.`;
  }
}

const person1 = new Person("Alice", 40);
const student1 = new Student("Bob", 20, "Computer Science");
const teacher1 = new Teacher("Dr. Smith", 45, "Mathematics");

const people = [person1, student1, teacher1];

people.forEach(p => {
  console.log(p.introduce());
  console.log(p.getRole());
  console.log("--------------------------------");
});

console.log(student1 instanceof Person);
console.log(teacher1 instanceof Student);
console.log(teacher1 instanceof Teacher);
