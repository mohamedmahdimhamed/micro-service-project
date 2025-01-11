import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from 'src/models/Student';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private httpClient:HttpClient) { }



  enregistrerStudent(student: any) {
    

    return this.httpClient.post('http://localhost:9090/student-service/api/student/create', student);
  }


  getAll():Observable<Student[]>{
    return this.httpClient.get<Student[]>(`http://localhost:9090/student-service/api/student/getAllStudent`);
  }

}
