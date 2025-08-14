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
