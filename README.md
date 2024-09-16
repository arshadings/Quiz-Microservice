# This is a Microservice based quiz application.
This quiz applicaiton is built using the spring boot microservices architecture.  

## Functionality
### 1. Admin:
* Create questions, options, difficulty level, category (Java, Python, etc.), and correct answers.
### 2. User:
* View question ID, question title, and options.  
* Submit responses.  
* View score based on responses.  

## Technical Overview  
### 1. Microservices:  
- **Question Service**: Contains the set of questions.
- **Quiz Service**: Requests the question service for the questions and gets the quiz id.
### 2. Quiz Creation:
- EndPoint: localhost:8084/quiz/create
- Category(Java, Python), number of questions needs to be created, and quiz title has to be passed.
- Questions are selected randomly from the available list.
  ```
  {
    "categoryName": "Java",
    "numQuestions": 3,
    "title": "Java Quiz 1"
  }
  ```
### 3. Response Handling:
- User responses are compared with correct answers, and the score is displayed.
### 4. Database:
Using H2 database for simplicity.

## Useful Steps to Run the Project
### 1. Access H2 Console:
- Open localhost:8080/h2-console.
- Login credentials:(Check the username/password in application.properties)
  - Username: sa
  - Password: password
### 2. Create Questions Table:
- If not present, create the table using:
```
  CREATE TABLE questions (
  id INT,
  category VARCHAR(255),
  difficultylevel VARCHAR(255),
  questiontitle VARCHAR(255),
  option1 VARCHAR(255),
  option2 VARCHAR(255),
  option3 VARCHAR(255),
  option4 VARCHAR(255),
  answer VARCHAR(255)
);
```
### 3. Insert Data:
- Insert sample data:
```
INSERT INTO questions (id, category, difficultylevel, questiontitle, option1, option2, option3, option4, answer) VALUES
(1, 'Java', 'Easy', 'What is the chemical symbol for water?', 'H2O', 'O2', 'CO2', 'H2', 'H2O'),
(2, 'Python', 'Medium', 'What is the value of Pi?', '3.14', '2.71', '1.62', '1.41', '3.14'),
(3, 'Java', 'Hard', 'What is the capital of Australia?', 'Sydney', 'Melbourne', 'Canberra', 'Brisbane', 'Canberra'),
(4, 'Python', 'Easy', 'Who was the first President of the United States?', 'George Washington', 'Thomas Jefferson', 'Abraham Lincoln', 'John Adams', 'George Washington'),
(5, 'Python', 'Medium', 'Who wrote "Romeo and Juliet"?', 'William Shakespeare', 'Charles Dickens', 'Mark Twain', 'Jane Austen', 'William Shakespeare'),
(6, 'Python', 'Hard', 'What planet is known as the Red Planet?', 'Earth', 'Mars', 'Jupiter', 'Saturn', 'Mars'),
(7, 'Java', 'Easy', 'What is 2 + 2?', '3', '4', '5', '6', '4'),
(8, 'Java', 'Medium', 'Which country is the largest by area?', 'China', 'Russia', 'Canada', 'USA', 'Russia'),
(9, 'Java', 'Hard', 'In which year did World War II end?', '1942', '1945', '1948', '1950', '1945'),
(10, 'Python', 'Easy', 'Who is the author of "Harry Potter"?', 'J.K. Rowling', 'J.R.R. Tolkien', 'George R.R. Martin', 'C.S. Lewis', 'J.K. Rowling');
```
### 4. Verify Data:
- Run:
```
SELECT * FROM QUESTIONS;
```

### 5. Create Quiz:
- Use Postman to send a POST request:
```
POST localhost:8084/quiz/get/7
```

### 6. Verify Quiz:
- Run:
```
SELECT * FROM QUIZ;
```

### 7. Verify Quiz Questions:
- Run:
```
SELECT * FROM QUIZ_QUESTIONS;
```

### 8. Submit Quiz:
- Use Postman to send a POST request:
```
POST localhost:8080/quiz/submit/1
```
- Body
```
[
  {
    "id": "9",
    "response": "1945"
  },
  {
    "id": "3",
    "response": "Canberra"
  },
  {
    "id": "8",
    "response": "Russia"
  }
]
```
- Replace IDs with those noted in step 7.
- Upon submission, you will see the score.
