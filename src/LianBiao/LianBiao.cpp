using namespace std;
#include <iostream>
#include "stdlib.h"

struct LianBiao {
    int data;
    LianBiao* pre;
    LianBiao* next;
};

void init(LianBiao* head) {
    head = (LianBiao*) malloc (sizeof(LianBiao));
}

void set(int* array, LianBiao* head) {
    LianBiao* last;
    LianBiao* cur;
    // 第一个元素
    last = (LianBiao*) malloc (sizeof(LianBiao));
    head->next = last;
    int size = sizeof(array)/sizeof(array[0]);
    cout<<size;
    for (int i = 0; i < size; i++) {
        cur = (LianBiao*) malloc (sizeof(LianBiao));
	cur->data = array[i];
	last->next = cur;
	last = cur;
    }
    last = NULL;
    cur = NULL;
    cout<<"\n";
}

void get(LianBiao* head) {
    LianBiao* iterator = head;
    while (iterator != NULL) {
        cout<<iterator->data;
	iterator = iterator->next;
    }
    cout<<"\n";
}

int main() {
    LianBiao* head;
    init(head);
    int a[] = {1,3,5,6,7,3,5,7,1};
    set(&a[0], head);
    get(head);
    return 0;
}
