import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student/student.component';
import { ListStudentComponent } from './list-student/list-student.component';

const routes: Routes = [
  {
    path:'createStudent',
    pathMatch:'full',
    component:StudentComponent

  },

  {
    path:'listStudent',
    pathMatch:'full',
    component:ListStudentComponent

  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {



 }
