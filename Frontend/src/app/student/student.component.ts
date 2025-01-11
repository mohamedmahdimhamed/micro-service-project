import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StudentService } from 'src/services/student.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  formGroup!: FormGroup;

  constructor(private studentService: StudentService, private router: Router) {}

  ngOnInit() {
    this.formGroup = new FormGroup({
      first_name: new FormControl(null, [Validators.required]),
      last_name: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [Validators.required, Validators.email]),
      city: new FormControl(null), // Optional field
      street: new FormControl(null, [Validators.required])
    });
  }

  submitForm() {
    if (this.formGroup.valid) {
      const data = {
        firstName: this.formGroup.get('first_name')?.value,
        lastName: this.formGroup.get('last_name')?.value,
        email: this.formGroup.get('email')?.value,
        city: this.formGroup.get('city')?.value,
        street: this.formGroup.get('street')?.value
      };

      this.studentService.enregistrerStudent(data).subscribe(
        () => {
          // Display success alert
          alert('New student added successfully!');
          // Redirect to listStudent path
          this.router.navigate(['listStudent']);
        },
        (error) => {
          // Handle errors
          console.error('Error adding student:', error);
          alert('An error occurred while adding the student. Please try again.');
        }
      );
    } else {
      alert('Please fill out all required fields correctly.');
    }
  }
}
