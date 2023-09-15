import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { map, catchError, retryWhen, delay, take } from 'rxjs/operators';

class HttpUtilService {

  constructor() { }

  
}

@Injectable({
  providedIn: 'root'
})
export class DashService {
constructor(private http: HttpClient, private httpUtil: HttpUtilService ) { }

private API_URL = "http://localhost:8080/";

buscarAlunosPorMes() {  
  return 10;
  // return this.http.get(this.API_URL + 'api/v1/dashboard/buscar-alunos-por-mes')
  //   .pipe(map(this.httpUtil.extrairDados))
  //   .pipe(
  //     retryWhen(errors => errors.pipe(delay(1000), take(10))),
  //     catchError(this.httpUtil.processarErros));
}

}