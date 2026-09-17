#[derive(Copy, Drop)]
struct Account {
    id: u32,
    balance: u32,
    is_active: bool,
}

#[derive(Copy, Drop)]
enum Transaction {
    Deposit: u32,
    Withdraw: u32,
    CloseAccount,
}

fn process_transaction(mut acc: Account, tx: Transaction) -> Account {
    assert!(acc.is_active, "Account is inactive");

    match tx {
        Transaction::Deposit(amount) => {
            acc.balance += amount;
        },
        Transaction::Withdraw(amount) => {
            assert!(acc.balance >= amount, "Insufficient balance");
            acc.balance -= amount;
        },
        Transaction::CloseAccount => {
            acc.balance = 0;
            acc.is_active = false;
        },
    }

    acc
}

#[test]
fn test_bank_flow() {
    let initial_acc = Account { id: 101, balance: 100, is_active: true };

    let acc_after_deposit = process_transaction(initial_acc, Transaction::Deposit(50));
    assert!(acc_after_deposit.balance == 150, "Deposit failed");

    let acc_after_withdraw = process_transaction(acc_after_deposit, Transaction::Withdraw(30));
    assert!(acc_after_withdraw.balance == 120, "Withdrawal failed");

    let closed_acc = process_transaction(acc_after_withdraw, Transaction::CloseAccount);
    assert!(closed_acc.balance == 0, "Close balance reset failed");
    assert!(!closed_acc.is_active, "Account should be inactive");
}