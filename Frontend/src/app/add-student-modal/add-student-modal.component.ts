import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { StudentService } from 'src/services/student.service';

@Component({
  selector: 'app-add-student-modal',
  templateUrl: './add-student-modal.component.html',
  styleUrls: ['./add-student-modal.component.css']
})
export class AddStudentModalComponent {
  formGroup: FormGroup;

  constructor(
    private studentService: StudentService,
    private dialogRef: MatDialogRef<AddStudentModalComponent>
  ) {
    this.formGroup = new FormGroup({
      first_name: new FormControl(null, [Validators.required]),
      last_name: new FormControl(null, [Validators.required]),
      email: new FormControl(null, [Validators.required, Validators.email]),
      city: new FormControl(null),
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

      this.studentService.enregistrerStudent(data).subscribe(() => {
        alert('New student added successfully!');
        this.dialogRef.close('success');
      });
    } else {
      alert('Please fill out all required fields.');
    }
  }

  closeModal() {
    this.dialogRef.close();
  }
}
