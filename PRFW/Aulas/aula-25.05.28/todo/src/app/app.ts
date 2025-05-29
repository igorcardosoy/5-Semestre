import { Component } from '@angular/core';
import { MatBadgeModule } from '@angular/material/badge';
import { MatIconModule } from '@angular/material/icon';
import { MatTableModule } from '@angular/material/table';
import { MatToolbarModule } from '@angular/material/toolbar';
import { TodoItem } from './todoItem';
import { TodoList } from './todoList';

@Component({
  selector: 'app-root',
  imports: [MatToolbarModule, MatIconModule, MatBadgeModule, MatTableModule],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  private list = new TodoList('Igor', [
    new TodoItem('Estudar Angular'),
    new TodoItem('Estudar TypeScript', true),
    new TodoItem('Estudar JavaScript'),
  ]);

  get username(): string {
    return this.list.user;
  }

  get itemCount(): number {
    return this.list.todoItems.filter((item) => !item.complete).length;
  }

  get items(): readonly TodoItem[] {
    return this.list.todoItems;
  }
}
