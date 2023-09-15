import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpServiceUtilService } from './http-service-util.service';
import { catchError, delay, map, retryWhen, take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http: HttpClient, private httpUtil: HttpServiceUtilService) { }

  private API_URL = "http://localhost:8080/";

  getTeacher() {
    return this.http.get(this.API_URL + 'api/v1/dashboard/buscar-professores')
      .pipe(map(this.httpUtil.extrairDados))
      .pipe(
        retryWhen(errors => errors.pipe(delay(1000), take(10))),
        catchError(this.httpUtil.processarErros));
  }


  getTotalTestsDone() {
    return this.http.get(this.API_URL + 'api/v1/dashboard/buscar-total-de-testes-finalizados')
      .pipe(map(this.httpUtil.extrairDados))
      .pipe(
        retryWhen(errors => errors.pipe(delay(1000), take(10))),
        catchError(this.httpUtil.processarErros));
  }


  getTotalSendAccess() {
    return this.http.get(this.API_URL + 'api/v1/dashboard/buscar-total-de-envio-acessos')
      .pipe(map(this.httpUtil.extrairDados))
      .pipe(
        retryWhen(errors => errors.pipe(delay(1000), take(10))),
        catchError(this.httpUtil.processarErros));
  }

  getTotalNewClients() {
    return this.http.get(this.API_URL + 'api/v1/dashboard/buscar-total-novos-clientes')
      .pipe(map(this.httpUtil.extrairDados))
      .pipe(
        retryWhen(errors => errors.pipe(delay(1000), take(10))),
        catchError(this.httpUtil.processarErros));
  }

  getAllStudents() {
    return this.http.get(this.API_URL + 'api/v1/dashboard/buscar-alunos-por-mes')
      .pipe(map(this.httpUtil.extrairDados))
      .pipe(
        retryWhen(errors => errors.pipe(delay(1000), take(10))),
        catchError(this.httpUtil.processarErros));
  }
}
