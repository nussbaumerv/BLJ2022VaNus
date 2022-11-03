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
    while (node != NULL) {
        printf("%d\n", node->value);
        node = node->nextNode;
    }
}

TNode* createNode(int newValue){
    TNode* newNode = (TNode*)malloc(sizeof(TNode));
    newNode->value = newValue;
    newNode->nextNode = NULL;
    return newNode;
}

TNode* addNode(int newValue, TNode* head){
   /* while (head != NULL) {
        head = head->nextNode;
    }
    */
    TNode* newNode = (TNode*)malloc(sizeof(TNode));
    newNode->value = newValue;
    newNode->nextNode = NULL;

    //head-> nextNode = newNode;


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

    addNode(12, first);

    printNode(first);
}
