export class TodoItem {
  public task: string;
  public complete: boolean;

  constructor(task: string, complete: boolean = false) {
    this.task = task;
    this.complete = complete;
  }
}
