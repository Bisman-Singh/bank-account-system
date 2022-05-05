# Bank Account System

A simple OOP bank account system with Savings and Checking accounts. Data persists to `accounts.dat` using Java serialization.

**Author:** Bisman Singh <bismanmadaan1@gmail.com>

## Features

- Abstract `Account` base class
- `SavingsAccount` (minimum balance 100)
- `CheckingAccount` (no minimum)
- Deposit, withdraw, getBalance
- Persistence via ObjectOutputStream to `accounts.dat`

## Build & Run

```bash
make
make run
```

## Usage

Menu options:
1. **Create account** - Choose savings or checking, enter number, holder, initial balance
2. **Deposit** - Enter account number and amount
3. **Withdraw** - Enter account number and amount
4. **Balance** - View balance by account number
5. **Quit** - Save and exit
