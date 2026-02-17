# 🗄️ Object-Oriented Mini Database Engine

> A lightweight, in-memory relational database simulation built entirely with **Core Java**, demonstrating OOP principles, file serialization, and CRUD operations through a console-based CLI.

---

## 📌 Project Overview

**Object-Oriented Mini Database Engine** is a console-based Java application that mimics the behavior of a basic Database Management System (DBMS). It allows users to perform SQL-like operations on an `Employee` table, with support for persistent storage via Java Serialization — meaning data survives between sessions.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java (Core) | Primary programming language |
| OOP (Classes, Encapsulation) | Data modeling and system design |
| Java Serialization (`Serializable`) | Persistent data backup and restore |
| Java Collections (`LinkedList`) | In-memory table storage |
| Java I/O (`FileOutputStream`, `ObjectOutputStream`) | Binary file read/write |
| `Scanner` | Console-based user input |

---

## ✨ Features

- ✅ **Insert** new employee records into the in-memory table
- ✅ **Select All** — display the full employee table
- ✅ **Search by ID** — retrieve a specific record using Employee ID
- ✅ **Search by Name** — retrieve all records matching an employee name
- ✅ **Delete by ID** — remove a specific record from the table
- ✅ **Backup** — serialize the entire database to a `.ser` file
- ✅ **Auto-Restore** — automatically loads the previous session's data on startup
- ✅ **Auto-Increment ID** — Employee IDs are assigned automatically via a static counter

---

## 🗂️ Project Structure
```
DBMS.java
│
├── class Empoloyee          # Entity/Model — represents a single employee record
│   ├── Fields: EmpID, EmpName, EmpAge, EmpAddress, EmpSalary
│   ├── Static Counter for auto-increment IDs
│   ├── DisplayInformation()
│   └── toString()
│
├── class MyDBMS             # Core DBMS engine — manages the employee table
│   ├── LinkedList<Empoloyee> Table  (in-memory storage)
│   ├── InsertIntoTable()
│   ├── SelectStarFrom()
│   ├── SelectSpecificID()
│   ├── SelectSpecificname()
│   ├── DeleteSpecificID()
│   ├── TakeBackup()         → serializes DB to "My DBMS.ser"
│   └── RestoreBackup()      → deserializes DB from file path
│
└── class MyDBMS (main)      # Main class — CLI menu loop
    └── main()
```

---

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Any terminal / command prompt

### Compile
```bash
javac DBMS.java
```

### Run
```bash
java DBMS
```

---

## 🖥️ CLI Menu

On launch, the application attempts to restore a previous backup automatically. If none exists, a fresh database is initialized.
```
-----------------------------------------------------------------------
------------------------------ My DBMS --------------------------------
-----------------------------------------------------------------------
1 : insert into Empoloyee
2 : select * from Empoloyee
3 : Take a backup of table
4 : select * from Empoloyee where EmpID = ___
5 : select * from Empoloyee where EmpName = ___
6 : delete from empoloyee where EmpId = ___
20 : Terminate the DBMS
-----------------------------------------------------------------------
```

---

## 💾 Persistence / Backup System

The database uses **Java Object Serialization** for persistence:

- **Backup** (`TakeBackup`): Serializes the entire `MyDBMS` object into a binary file — `My DBMS.ser`.
- **Restore** (`RestoreBackup`): On every startup, reads `My DBMS.ser` and deserializes the object back into memory, restoring the last saved state.

> ⚠️ Backup must be triggered manually via **Option 3**. Data added after the last backup will be lost on exit without saving.

---

## 📐 OOP Concepts Demonstrated

| Concept | Where Applied |
|---|---|
| **Encapsulation** | `Employee` fields initialized via constructor |
| **Static Members** | Auto-increment `Counter` in `Employee` |
| **Serialization** | Both `MyDBMS` and `Employee` implement `Serializable` |
| **Abstraction** | `MyDBMS` hides `LinkedList` internals behind clean method APIs |
| **toString() Override** | Custom record display in `Employee` |
| **Static Factory Method** | `RestoreBackup()` returns a `MyDBMS` instance from file |

---

## ⚠️ Known Limitations

- Employee IDs reset on a fresh start (static counter is not persisted)
- No `UPDATE` functionality to edit existing records
- No input validation (negative salaries/ages are accepted)
- Backup file path is hardcoded as `"My DBMS.ser"`
- `"Empoloyee"` is a typo throughout the codebase (original spelling preserved)

---

## 🔮 Possible Enhancements

- Add `UPDATE` functionality for modifying existing records
- Persist the static `Counter` to prevent ID reuse across sessions
- Add salary range and age-based filtering
- Replace serialization with JSON/CSV for portability
- Add input validation and error handling for invalid entries
- Implement record sorting by name, salary, or age

---

## 📄 License

This project is open-source and available for educational use.
