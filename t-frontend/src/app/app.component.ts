import { Component, OnInit } from '@angular/core';
import {TodoService} from "./app.service";
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/operator/toPromise';
import 'rxjs/Observable';


@Component({
  selector: 'my-app',
  templateUrl: './app.component.html',
})
export class AppComponent implements OnInit {
  name = 'Todo';

  todoList:any = [];

  constructor(private todoService: TodoService) {}

  ngOnInit(){

    return this.todoService.getTodoList().subscribe(
        (data) => {
          this.todoList = data
          console.log(this.todoList)
        }
        ,
        (error) => alert("Unable to fetch the list " + error)
    )
  }
}
