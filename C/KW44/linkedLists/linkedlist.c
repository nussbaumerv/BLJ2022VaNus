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

TNode* delNodeN(int index, TNode** pp_head){
    int counter = 1;
    TNode* head = *pp_head;
    TNode* after = head-> nextNode;

    if(index < 2){
        pp_head = &(head-> nextNode);
        free(head);
    }
    else {
        while (counter < index - 1) {
            head = head->nextNode;
            after = head->nextNode;
            counter++;
        }

        head->nextNode = after->nextNode;
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
    delNodeN(1, &first);

    printNode(first);
}
