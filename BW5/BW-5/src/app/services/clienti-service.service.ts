import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cliente } from '../interfaces/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClientiServiceService {

  apiURL = 'http://localhost:8080/api/clienti'

  constructor(private http: HttpClient) { }

  getClienti(){
    return this.http.get<Cliente[]>(this.apiURL)
  }
}
