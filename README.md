
# 🔥 FLAMES Relationship Application

## 📌 Project Overview

A simple web-based FLAMES game that calculates relationship status based on two names using classic FLAMES logic.

**Tech Stack:**

* Frontend: HTML, CSS, JavaScript
* Backend: Java, Spring Boot
* Communication: REST API

---

## 🎯 Features

* User-friendly UI
* Real-time relationship calculation
* Validates empty and invalid inputs
* Displays result with text + image
* Clean separation of frontend and backend

---

## 🧠 FLAMES Logic

FLAMES stands for:

* **F** – Friends
* **L** – Love
* **A** – Affection
* **M** – Marriage
* **E** – Enemy
* **S** – Sister

**Algorithm Steps:**

1. Remove common characters from both names.
2. Count remaining letters.
3. Use count to eliminate FLAMES letters cyclically.
4. Final remaining letter = Result.

---

## 🖥️ Screens Flow

1. **Input Screen**

   * Enter Male Name
   * Enter Female Name
   * Click Submit

2. **Result Screen**

   * Relationship Text
   * Related Image Display

---

## 🛠 Tech Architecture

```
Frontend (HTML + CSS + JS)
        |
        v
REST API Call (JSON)
        |
        v
Spring Boot Backend (Java)
        |
        v
FLAMES Logic Processing
        |
        v
Return Result → UI Display
```

---

## 🚀 How To Run

### Backend (Spring Boot)

```bash
git clone <repo-url>
cd flames-backend
mvn spring-boot:run
```

Runs at:

```
http://localhost:8080
```

---

### Frontend

```bash
Open index.html using Live Server
OR
Open directly in browser
```

---

## 📡 Sample API

**POST:** `/api/flames`

**Request JSON:**

```json
{
  "maleName": "Amar",
  "femaleName": "Nisha"
}
```

**Response JSON:**

```json
{
  "result": "Love"
}
```

---

## 🧪 Sample Input & Output

| Male Name | Female Name | Result   |
| --------- | ----------- | -------- |
| Ram       | Sita        | Love     |
| Arun      | Kavi        | Friends  |
| John      | Mary        | Marriage |

---

## 📂 Project Structure

```
flames-project/
 ├── frontend/
 │    ├── index.html
 │    ├── style.css
 │    └── script.js
 └── backend/
      ├── controller/
      ├── service/
      ├── model/
      └── FlamesApplication.java
```

---

## ⚠️ Known Limitations

* No database storage
* No authentication
* Simple UI
* No deployment config

---

## 🔧 Future Improvements

* Mobile responsive UI
* Sound effects
* Animations
* Database history
* Login system

---

## 👨‍💻 Author

**Amarnath**
Java | Spring Boot | Frontend Developer

---

