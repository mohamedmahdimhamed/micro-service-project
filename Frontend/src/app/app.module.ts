import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { StudentComponent } from './student/student.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ListStudentComponent } from './list-student/list-student.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog'; // For modals
import { MatButtonModule } from '@angular/material/button'; // For buttons
import { MatFormFieldModule } from '@angular/material/form-field'; // For mat-form-field
import { MatInputModule } from '@angular/material/input'; // For mat-input
import { AddStudentModalComponent } from './add-student-modal/add-student-modal.component';

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    ListStudentComponent,
    AddStudentModalComponent // Ensure this is declared
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatSlideToggleModule,
    BrowserAnimationsModule,
    MatPaginatorModule,
    MatTableModule,
    MatIconModule,
    MatDialogModule, // Import this
    MatButtonModule, // Import this
    MatFormFieldModule, // Import this
    MatInputModule, // Import this
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
