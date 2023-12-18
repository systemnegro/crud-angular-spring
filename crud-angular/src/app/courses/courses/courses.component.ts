import { Component } from '@angular/core';
import { Course } from "../models/course";
import { CoursesService } from "../services/courses.service";
import { catchError, Observable, of } from "rxjs";
import { MatDialog } from "@angular/material/dialog";
import { ErrorDialogComponent } from "../../shared/components/error-dialog/error-dialog.component";
import { ActivatedRoute, Router } from "@angular/router";



@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent {

  courses$: Observable<Course[]>;


  constructor(
    private coursesService: CoursesService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
    ) {

    this.courses$ = this.coursesService.list()
      .pipe(
        catchError(error => {
          this.onError('Erro ao carregar.')
          return of([])
        })
      );
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  onAdd(){
    this.router.navigate(['new'], {relativeTo: this.route});
  }


}
