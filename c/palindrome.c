#include <stdio.h>
#include <string.h>
#include <ctype.h>

// Function to check if a number is a palindrome
int isNumberPalindrome(int num) {
    int original = num, reversed = 0;

    while (num > 0) {
        reversed = reversed * 10 + num % 10;
        num /= 10;
    }

    return original == reversed;
}

// Function to check if a string is a palindrome
int isStringPalindrome(char str[]) {
    int left = 0;
    int right = strlen(str) - 1;

    while (left < right) {
        // Ignore non-alphanumeric characters and case
        while (left < right && !isalnum(str[left])) left++;
        while (left < right && !isalnum(str[right])) right--;

        if (tolower(str[left]) != tolower(str[right]))
            return 0;

        left++;
        right--;
    }

    return 1;
}

int main() {
    char input[100];
    printf("Enter a number or a string: ");
    scanf("%s", input);

    int isNum = 1;
    for (int i = 0; input[i]; i++) {
        if (!isdigit(input[i])) {
            isNum = 0;
            break;
        }
    }

    if (isNum) {
        int number = atoi(input);
        if (isNumberPalindrome(number))
            printf("It's a palindrome number.\n");
        else
            printf("It's not a palindrome number.\n");
    } else {
        if (isStringPalindrome(input))
            printf("It's a palindrome string.\n");
        else
            printf("It's not a palindrome string.\n");
    }

    return 0;
}

Shall I add it to git?
