//
// Created by nussb on 03.11.2022.
//
#include <stdio.h>
#include "stdlib.h"
#include "windows.h"

typedef struct Node {
    struct node *p_value;
    struct node *nextNode;
} TNode;

typedef struct Value{
    int value;
} TValue;


int getLenght(TNode *head) {
    int counter = 0;
    while (head != NULL) {
        counter += 1;
        head = head->nextNode;
    }
    return counter;
}

void printAllNodes(TNode *head) {
    int counter = 0;
    printf("\n**********************************************************************************\n\n");
    while (head != NULL) {
        counter += 1;
        TValue *value = head->p_value;
        printf("%d | %d\n", counter, value->value);
        head = head->nextNode;
    }
}

void printCertainNode(TNode* head, int index) {
    int counter = 1;
    printf("\n**********************************************************************************\n\n");

    if (index > 0 && index <= getLenght(head)) {
        while (counter < index) {
            head = head->nextNode;
            counter++;
        }
        if (counter == index) {
            TValue *value = head->p_value;
            printf("%d | %d\n", counter, value->value);

        }
    } else {
        printf("Enter a valid number");
    }
}

TNode *createNode(int newValue) {
    TNode *newNode = (TNode *) malloc(sizeof(TNode));
    TValue *Value = (TValue *) malloc(sizeof(TValue));
    Value->value = newValue;
    newNode->p_value = Value;
    newNode->nextNode = NULL;
    return newNode;
}

TNode *addNodeEnd(TNode *head, int newValue) {
    TNode *newNode = createNode(newValue);

    while (head->nextNode != NULL) {
        head = head->nextNode;
    }

    if (head->nextNode == NULL) {
        head->nextNode = newNode;
    }
    printf("\nNode got successfully added!\n");
}

TNode *addNodeIndex(TNode **pp_head, int index, int newValue) {
    int counter = 1;
    TNode *head = *pp_head;
    TNode *after = head->nextNode;
    TNode *added = createNode(newValue);

    if (index > 0 && index <= getLenght(head)) {
        if (index == 1) {
            *pp_head = (added);
            added->nextNode = head;

        } else {
            while (counter < index - 1) {
                head = head->nextNode;
                after = head->nextNode;
                counter++;
            }
            head->nextNode = added;
            added->nextNode = after;
        }
        printf("\nNode got successfully added!\n");
    } else {
        printf("Enter a valid number");
    }
}


TNode *updateCertainNode(TNode *head, int index, int newValue) {
    int counter = 1;

    if (index > 0 && index <= getLenght(head)) {
        while (counter < index) {
            head = head->nextNode;
            counter++;
        }
        if (counter == index) {
            TValue *value = head->p_value;
            value->value = newValue;
        }
        printf("\nNode got successfully updated!\n");
    } else {
        printf("Enter a valid number");
    }
}

void updateAllNodes(TNode *head, int newValue) {
    while (head != NULL) {
        TValue *value = head->p_value;
        value->value = newValue;
        head = head->nextNode;
    }
    printf("\nList got successfully updated!\n");
}


void deleteAllNodes(TNode *head) {
    int length = getLenght(head);
   TNode* temp = head;
   TValue *value = head->p_value;
    for(int i = 0; i < length; i++) {
        value = head->p_value;
       temp = head->nextNode;
       free(head);
        free(value);
       head = temp;
    }
    if(!head){
        printf("\nList got successfully deleted!\n");
    }
}

TNode *deleteSpecificNode(TNode **pp_head, int index) {
    int counter = 1;
    TNode *head = *pp_head;
    TNode *after = head->nextNode;
    TValue *value = head->p_value;
    int length = getLenght(head);

    if (index > 0 && index <= length) {
            if (index == 1) {
                *pp_head = (head->nextNode);
                free(value);
                free(head);
            } else {
                while (counter < index - 1) {
                    head = head->nextNode;
                    after = head->nextNode;
                    counter++;
                }

                head->nextNode = after->nextNode;
            }
            printf("\nNode got successfully deleted!\n");
    } else {
        printf("Enter a valid number");
    }
}


int scanIndex(){
    int index = 0;
    printf("Enter Index:");
    scanf("%d", &index);
    return index;
}
int scanValue(){
    int input = 0;
    printf("Enter Value:");
    scanf("%d", &input);
    return input;
}


int launchNode() {
    int keepDoing = 1;
    int input = 0;
    printf("\n**********************************************************************************\n");
    printf("Welcome to my program");
    printf("\n**********************************************************************************\n\n");
    printf("What should be the value of the first node?\n");
    int firstValue = scanValue();

    TNode *head = createNode(firstValue);
    do {
        printf("\nWhat feature do you want to use?\n\n");
        printf(""
               "    1. Add Node to the end of linked list\n"
               "    2. Add Node to specific place in linked list\n\n"

               "    3. Print entire linked list\n"
               "    4. Print specific node linked list\n\n"

               "    5. Print length of linked list\n\n"

               "    6. Change value of specific node\n"
               "    7. Change all values of linked list\n\n"

               "    8. Delete specific node\n"
               "    9. Delete all nodes\n\n"

               "    10. Exit\n"
               "");

        printf("\nEnter specific number:");
        scanf("%d", &input);

        if (input == 1) {
            int newValue = scanValue();
            addNodeEnd(head, newValue);
        } else if (input == 2) {
            int index = scanIndex();
            int newValue = scanValue();
            addNodeIndex(&head, index, newValue);
        } else if (input == 3) {
            printAllNodes(head);
        } else if (input == 4) {
            int index = scanIndex();
            printCertainNode(head, index);
        } else if (input == 5) {
            printf("\n**********************************************************************************\n\n");
            printf("Length of linked list: %d Nodes\n",getLenght(head));
        } else if (input == 6) {
            int index = scanIndex();
            int newValue = scanValue();
            updateCertainNode(head, index, newValue);

        } else if (input == 7) {
            int newValue = scanValue();
            updateAllNodes(head, newValue);
        } else if (input == 8) {
            int index = scanIndex();
            if(getLenght(head) == 1){
                deleteAllNodes(head);
                keepDoing = 0;
            }
            else {
                deleteSpecificNode(&head, index);
            }
        } else if (input == 9) {
            deleteAllNodes(head);
            keepDoing = 0;
        } else if (input == 10) {
            keepDoing = 0;
        }
        printf("\n**********************************************************************************\n");
    }
    while(keepDoing == 1);
    printf(""
           "\n**********************************************************************************\n"
           "Thanks for using my program!"
           "\n**********************************************************************************\n"
           );
}
