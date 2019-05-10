import { Service } from './service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

export abstract class AbstractService<DTO> implements Service<DTO> {

    type: string;

    constructor(protected http: HttpClient) {

    }

      getAll(): Observable<DTO[]> {
      return this.http.get<DTO[]>('http://localhost:8080/' + this.type + '/getall');
  }

  read(id: number): Observable<DTO> {
      return this.http.get<DTO>('http://localhost:8080/' + this.type + '/read?id=' + id);
  }

  delete(id: number): Observable<any> {
      return this.http.delete('http://localhost:8080/' + this.type + '/delete?id=' + id);
  }

  insert(apartment: DTO): Observable<any> {
      return this.http.post('http://localhost:8080/' + this.type + '/insert', apartment);
  }

  update(apartment: DTO): Observable<any> {
      return this.http.put('http://localhost:8080/' + this.type + '/update', apartment);
  }
}
