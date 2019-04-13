import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  FormControl
} from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-searchmovie',
  templateUrl: './searchmovie.component.html',
  styleUrls: ['./searchmovie.component.css']
})
export class SearchmovieComponent implements OnInit {

  constructor(fb: FormBuilder,private http: HttpClient) {
    this.formControl = fb.group({
      'movieGenre': ['',Validators.required]
    });
  }

  ngOnInit() {
  }

  formControl: FormGroup;
  movieGenre: string;
  movieList;

  onSubmit() {  
    console.log("Invoking submit!");
    if (this.formControl.invalid) {
      console.log("Form is Invalid!");
      return false;
    }
    console.log("Form submitted successfully!");
    console.log("Value is : " + this.movieGenre);
    this.http.get("http://localhost:5000/searchMovie/"+this.movieGenre).subscribe(data => {
      this.movieList=data;
      console.log("Getting list of movies");
    });
  }
}
