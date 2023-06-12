use rust;

#[test]
fn test_add() {
    let sum = rust::add(1, 2);
    assert_eq!(3, sum);
}

#[test]
fn test_fail() {
    assert_eq!(1, 2);
}