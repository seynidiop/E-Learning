import { Component, computed, inject, signal } from '@angular/core';
import { ProductCard } from '../product-card/product-card';
import { Produit } from '../../models/produit';
import { MatIcon } from '@angular/material/icon';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { CartService } from '../cart-service';


@Component({
  selector: 'app-produits',
  imports: [ProductCard,MatIcon,MatFormFieldModule,MatInputModule,FormsModule],
  templateUrl: './produits.html',
  styleUrl: './produits.css',
})
export class Produits {



  private readonly cartService = inject(CartService);
  protected readonly searchTerm = signal('');
  protected readonly products = signal<Produit[]>([
   
  {
    id: 1,
    name: 'Riz parfumé',
    description: 'Riz parfumé de qualité supérieure, idéal pour accompagner vos plats.',
    price: 3500,
    onSalePrice: 3000,
    category: 'Céréales'
  },
  {
    id: 2,
    name: 'Huile de tournesol',
    description: 'Huile de tournesol raffinée, parfaite pour la cuisson et les fritures.',
    price: 4500,
    category: 'Huiles'
  },
  {
    id: 3,
    name: 'Lait en poudre',
    description: 'Lait en poudre riche en calcium, adapté à toute la famille.',
    price: 5500,
    category: 'Produits laitiers'
  },
  {
    id: 4,
    name: 'Spaghetti',
    description: 'Pâtes alimentaires de qualité, faciles et rapides à préparer.',
    price: 1200,
    onSalePrice: 1000,
    category: 'Pâtes'
  },
  {
    id: 5,
    name: 'Sucre blanc',
    description: 'Sucre blanc fin idéal pour les boissons chaudes, pâtisseries et desserts.',
    price: 1000,
    category: 'Épicerie'
  },
  {
    id: 6,
    name: 'Café moulu',
    description: 'Café moulu aux arômes intenses pour bien commencer la journée.',
    price: 3000,
    onSalePrice: 2500,
    category: 'Boissons'
  },
  {
    id: 7,
    name: 'Jus de mangue',
    description: 'Boisson fruitée à base de mangue avec une saveur douce et rafraîchissante.',
    price: 1500,
    category: 'Boissons'
  },
  {
    id: 8,
    name: 'Biscuits au chocolat',
    description: 'Délicieux biscuits croustillants avec de généreuses pépites de chocolat.',
    price: 2000,
    category: 'Biscuits'
  },
  {
    id: 9,
    name: 'Thon en conserve',
    description: 'Thon en conserve riche en protéines, idéal pour les salades et sandwichs.',
    price: 2500,
    onSalePrice: 2200,
    category: 'Conserves'
  },
  {
    id: 10,
    name: 'Tomates fraîches',
    description: 'Tomates fraîches et bien mûres, parfaites pour les salades et les sauces.',
    price: 1800,
    category: 'Fruits et légumes'
  }

  ]);


  protected readonly filteredProducts = computed(() => {
    const term = this.searchTerm().trim().toLowerCase();
    if (!term) { return this.products(); }
    return this.products().filter((product) =>
      product.category.toLowerCase().includes(term) ||
      product.description.toLowerCase().includes(term)
    );
  })


  protected AddToCard(product: Produit) {
    this.cartService.addToCart(product);
  }
  protected clearSearchTerm() {
    this.searchTerm.set('');
  }
  protected trimSearchTerm() {
    this.searchTerm.update((term) => term.trim());
  }
}
