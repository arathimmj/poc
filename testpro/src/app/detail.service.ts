import { Injectable } from '@angular/core';
import { HttpClient,HttpResponse,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class DetailService {

  constructor(private http: HttpClient) { }

  postDetail(detail):Observable<any>{
    console.log(detail)
    return this.http.post<any>('http://localhost:8080/api/v1/detail',detail);
  }
}
