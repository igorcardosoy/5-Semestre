import { TodoItem } from './todoItem';

export class TodoList {
  public user: string;
  public todoItems: TodoItem[];

  constructor(user: string, todoItems: TodoItem[]) {
    this.user = user;
    this.todoItems = todoItems;
  }
}
