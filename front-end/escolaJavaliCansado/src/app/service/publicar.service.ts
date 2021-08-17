import { Observable } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.prod';
import { Publish } from '../model/Publish';

@Injectable({
  providedIn: 'root'
})
export class PublicarService {

  constructor(private http: HttpClient) { }

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  };

  getAllPublish(): Observable <Publish[]> {
    return this.http.get<Publish[]>('http://localhost:8080/publicar', this.token);
  }

  postPublish(publish: Publish): Observable<Publish>{
    return this.http.post<Publish>('http://localhost:8080/publicar', publish, this.token);
  }
}
