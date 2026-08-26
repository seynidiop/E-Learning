import { Component, input, output } from '@angular/core';
import { MatButton } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { Produit } from '../../models/produit';

@Component({
  selector: 'app-product-card',
  imports: [MatCardModule,MatButton],
  templateUrl: './product-card.html',
  styleUrl: './product-card.css',
})
export class ProductCard {
  readonly product = input.required<Produit>();
  protected addButton=input('Add to Cart');

  readonly toCard= output<Produit>();
  protected addToCart() {
    this.toCard.emit(this.product());
  }

}
