//
// Created by nussb on 03.11.2022.
//
#include <stdio.h>
#include "stdlib.h"
typedef struct Node{
    int value;
    struct node* nextNode;
} TNode;

void printNode(TNode* node)
{
    int counter = 0;
    while (node != NULL) {
        counter += 1;
        printf("%d | %d\n", counter, node->value);
        node = node->nextNode;
    }
    printf("---------\n");
}

TNode* createNode(int newValue){
    TNode* newNode = (TNode*)malloc(sizeof(TNode));
    newNode->value = newValue;
    newNode->nextNode = NULL;
    return newNode;
}

TNode* addNodeEnd(int newValue, TNode* head){
    TNode* newNode = createNode(newValue);

   while (head->nextNode != NULL) {
       head = head->nextNode;
    }

    if(head->nextNode == NULL) {
        head->nextNode = newNode;
    }
}

TNode* delNodeN(int index, TNode* head){
    int counter = 2;
    TNode* after = head-> nextNode;
    while (counter < index) {
        head = head->nextNode;
        after = head->nextNode;
        counter++;
    }

    if(counter == index){
        head->nextNode = after->nextNode;
        free(after);
    }

}

TNode* delNode(TNode* node, TNode* head){
    while (head->nextNode != node) {
        head = head->nextNode;
    }

    if(head->nextNode == node){
        head->nextNode = node->nextNode;
        free(node);
    }

}
int launchNode(){
    TNode* first = createNode(30);
    TNode* second = createNode(360);
    TNode* third = createNode(10);
    TNode* forth = createNode(40);
    TNode* fifth = createNode(130);

    first->nextNode = second;
    second->nextNode = third;
    third->nextNode = forth;
    forth->nextNode = fifth;

    addNodeEnd(12, first);
    addNodeEnd(223, first);
    addNodeEnd(1233, first);

    printNode(first);

    //delNode(second, first);
    delNodeN(2, first);

    printNode(first);
}
