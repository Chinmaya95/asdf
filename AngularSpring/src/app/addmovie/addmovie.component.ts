import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Movie } from '../model/movies';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Component({
  selector: 'app-addmovie',
  templateUrl: './addmovie.component.html',
  styleUrls: ['./addmovie.component.css']
})
export class AddmovieComponent implements OnInit {



  constructor(fb: FormBuilder, private http: HttpClient) {
    this.formControl = fb.group({
      'movieName': ['', Validators.required],
      'movieRating': ['', [Validators.min(1), Validators.max(5)]],
      'movieGenre': ['', Validators.required]
    });
  }

  ngOnInit() {
  }

  formControl: FormGroup;
  movieName: string;
  movieRating: number;
  movieGenre: string;
  movie: Movie;

  onSubmit() {
    console.log("Invoking submit!");
    if (this.formControl.invalid) {
      console.log("Form is Invalid!");
      return false;
    }
    console.log("Form submitted successfuly!");
    console.log("Values are : " + this.movieName + " " + this.movieRating + " " + this.movieGenre);
    this.movie = new Movie();
    this.movie.moviesName = this.movieName;
    this.movie.moviesRating = this.movieRating;
    this.movie.moviesGenre = this.movieGenre;
    console.log(this.movie);
    this.http.post("http://localhost:5000/addMovie", this.movie, httpOptions).subscribe();
  }

}
