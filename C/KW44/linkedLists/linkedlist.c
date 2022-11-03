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

int createNode(){
    TNode* first = (TNode*)malloc(sizeof(TNode));
    TNode* second = (TNode*)malloc(sizeof(TNode));
    TNode* third = (TNode*)malloc(sizeof(TNode));

    first->value = 45;
    first->nextNode = second;

    second->value = 30;
    second->nextNode = third;

    third-> value = 12;
    third->nextNode = NULL;

    printNode(first);
}
