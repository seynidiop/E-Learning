import { Component, signal , computed} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './features/header/header';
import { Produits } from './features/produits/produits';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet,Header,Produits],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  
}
