import { AfterViewInit, Component, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatDialog } from '@angular/material/dialog';
import { Student } from 'src/models/Student';
import { StudentService } from 'src/services/student.service';
import { AddStudentModalComponent } from '../add-student-modal/add-student-modal.component'; // Import the modal component

@Component({
  selector: 'app-list-student',
  templateUrl: './list-student.component.html',
  styleUrls: ['./list-student.component.css']
})
export class ListStudentComponent implements AfterViewInit {
  displayedColumns: string[] = ['firstname', 'lastname', 'email', 'city', 'street'];
  dataSource = new MatTableDataSource<Student>();
  @ViewChild(MatPaginator) paginator!: MatPaginator;

  constructor(private studentService: StudentService, private dialog: MatDialog) {}

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  ngOnInit() {
    this.fetchStudents();
  }

  fetchStudents() {
    this.studentService.getAll().subscribe((students: Student[]) => {
      this.dataSource.data = students;
    });
  }

  openAddStudentModal() {
    const dialogRef = this.dialog.open(AddStudentModalComponent, {
      width: '500px',
      disableClose: true // Prevent closing the modal by clicking outside
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result === 'success') {
        this.fetchStudents(); // Refresh the table after a successful addition
      }
    });
  }
}
