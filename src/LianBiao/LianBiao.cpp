#include <iostream>

struct LianBiao {
    int data;
    LianBiao* pre;
    LianBiao* next;
}

void init(LianBiao* head) {
    head = (LianBiao*) malloc (sizeof(LianBiao));
}

void set(int* array, LianBiao* head) {
    LianBiao* last;
    LianBiao* cur;
    cur = (LianBiao*) malloc (sizeof(LianBiao));
    for (int i = 0; i < array.length; i++) {
        cur = (LianBiao*) malloc (sizeof(LianBiao));
	last->next = cur;
    }
}

int main() {
    LianBiao* head;
    init(head);
    return 0;
}
