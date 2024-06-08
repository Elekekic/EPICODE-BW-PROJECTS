import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Fatture } from '../interfaces/fatture';
import { Observable } from 'rxjs';
import { NgForm } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class FattureService {

   apiURL = 'http://localhost:8080/api/fatture'
   apifattureURL = 'http://localhost:8080/api/fattureByCliente'



  constructor(private http: HttpClient) { }

  getFatture(){
    return this.http.get<Fatture[]>(this.apiURL)
  }


  getFattureByClienteId(clienteId: number): Observable<Fatture[]> {
    const url = `${this.apifattureURL}/${clienteId}`;
    return this.http.get<Fatture[]>(url);
  }


  postAggiungiFattura(body:any): Observable<Fatture> {
    const url = `${this.apiURL}`;

    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
      responseType: 'text' as 'json' // Specifica il tipo di risposta come testo
    };
    return this.http.post<Fatture>(url, body, httpOptions);
  }

}
