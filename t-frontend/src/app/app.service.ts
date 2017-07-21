import {Injectable} from "@angular/core";
import {Http} from "@angular/http";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/debounceTime";
import "rxjs/add/operator/distinctUntilChanged";
import "rxjs/add/operator/switchMap";
import "rxjs/add/operator/toPromise";
import "rxjs/Observable";

@Injectable()
export class TodoService {


    constructor(private http: Http){}

    todoListApi = 'https://api.github.com/gists/public';

    getTodoList(){
        return this.http.get(this.todoListApi).map(
            (data) => data.json()
        )
    }
}
