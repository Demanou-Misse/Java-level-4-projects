# Java Level 4 Projects ⚙️

Welcome! This repository contains six intermediate-to-advanced Java projects designed to reinforce my skills in **Generics**, **Enums**, **Multithreading**, **Lambda expressions**, and the **Stream API**.

Each project is cleanly organized into folders with the structure: `model`, `service`, `main`, and `data`. All projects are console-based and ready to be extended or refactored.

---

## 📚 Projects Overview

---

### ✅ 1. Multithreaded Task Manager

**Goals:**

- Manage tasks with priorities and reminders
- Schedule notifications using multithreading
- Use `Enum` for task priority
- Persist data in a `.txt` file

**What it does:**

- Add tasks with title, time, and priority (LOW, MEDIUM, HIGH)
- Display all or filtered tasks
- Schedule reminders using `ExecutorService`
- Save/load tasks automatically from file

📌 **Concepts Used:** `Enum`, `ExecutorService`, `Lambda`, `Stream`, `FileReader`, `FileWriter`, `Map<String, List<Task>>`

📂 Folder: `/taskmanager`

---

### ✅ 2. Log File Analyzer

**Goals:**

- Analyze structured `.log` files
- Use regex and `Stream` to parse and filter logs
- Count and sort entries by severity and frequency

**What it does:**

- Load a `.txt` log file
- Count INFO, WARN, ERROR entries
- Sort logs by timestamp
- Show top repeated error messages

📌 **Concepts Used:** `Stream`, `Pattern`, `Matcher`, `List<String>`, filtering and grouping operations

📂 Folder: `/loganalyzer`

---

### ✅ 3. Banking Simulator with Generics

**Goals:**

- Simulate bank accounts using `Generics`
- Allow money transfers between threads
- Prevent race conditions with `synchronized`

**What it does:**

- Define accounts like `Compte<Double>`, `Compte<Float>`
- Use `Enum` for account types (EPARGNE, COURANT)
- Simulate concurrent transfers between accounts
- Ensure thread safety on account balance

📌 **Concepts Used:** `Generics`, `Enum`, `Thread`, `synchronized`, `wait/notify`

📂 Folder: `/banksimulator`

---

### ✅ 4. Student Grade Aggregator

**Goals:**

- Collect and process grades using `Generics` and `Stream`
- Group and sort students by performance and subject

**What it does:**

- Add student grades with a generic `Note<T extends Number>`
- Use `Enum` for subjects (MATH, ENGLISH, etc.)
- Compute averages and top performers with Streams
- Display report by subject

📌 **Concepts Used:** `Generics`, `Stream`, `EnumMap`, `Collectors`

📂 Folder: `/studentgrades`

---

### ✅ 5. Text File Analyzer

**Goals:**

- Extract key metrics from large `.txt` documents
- Use `Stream` and regex to filter and analyze text

**What it does:**

- Count words, lines, characters
- Find most frequent words
- Detect similarity between two texts (basic plagiarism detection)
- Display stats in console

📌 **Concepts Used:** `BufferedReader`, `Stream`, `Lambda`, `Pattern`, `Map<String, Integer>`

📂 Folder: `/textanalyzer`

---

### ✅ 6. Multi-Unit Converter

**Goals:**

- Build a universal converter with `Enum`, `Map`, and `Lambda`
- Organize conversion formulas cleanly

**What it does:**

- Convert distances, weights, temperatures
- Enum for unit types (KM, MILES, CELSIUS, FAHRENHEIT…)
- Store conversion formulas in a `Map<Enum, Function<Double, Double>>`
- Interactive CLI-based converter

📌 **Concepts Used:** `Enum`, `Map`, `Function`, `Lambda`, console input handling

📂 Folder: `/unitconverter`

---

## 🛠️ How to Run the Projects

1. Open your IDE (IntelliJ, Eclipse, VS Code…).
2. Open a project folder (e.g., `/taskmanager`).
3. Run the `Main.java` file inside `/main`.
4. Use the terminal to interact with the app.

---

## 📬 Contact

If you have questions or ideas, feel free to reach out:

* GitHub: [Demanou-Misse](https://github.com/Demanou-Misse)  
* Email: [missedemanou@gmail.com](mailto:missedemanou@gmail.com)

---

Keep pushing your limits. Advanced Java unlocked 🚀
