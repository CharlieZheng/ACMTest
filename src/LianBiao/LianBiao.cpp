using namespace std;
#include <iostream>
#include "stdlib.h"

struct LianBiao {
    int data;
    LianBiao* pre;
    LianBiao* next;
};

void set(int* array, LianBiao* head) {
    
    // 第一个元素
    LianBiao* last = (LianBiao*) malloc (sizeof(LianBiao));
    LianBiao* cur = last;
    cout<<array[0]<<"\t";
    last->data = array[0];
    head = last;
    int size = 9;
    // 从一开始，减去第一个元素
    for (int i = 1; i < size; i++) {
        cur = (LianBiao*) malloc (sizeof(LianBiao));
		cout<<array[i]<<"\t";
		cur->data = array[i];
		last->next = cur;
		last = cur;
    }
	cur = head;
	while (cur != NULL) {
		cout<<cur->data<<"\t";
		cur = cur->next;
	}
    
    last = NULL;
    cur = NULL;
    cout<<"\n";
}

void get(LianBiao* head) {
    LianBiao* iterator = head;
    while (iterator != NULL) {
        cout<<iterator->data<<"\t";
		iterator = iterator->next;
    }
    cout<<"\n";
}

int main() {
    struct LianBiao* head = (LianBiao*) malloc (sizeof(LianBiao));
    int a[9] = {1,3,5,6,7,3,5,7,1};
    set(&a[0], head);
    get(head);
    return 0;
}
