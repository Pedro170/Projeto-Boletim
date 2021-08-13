import { CadastroLoginComponent } from './cadastro-login/cadastro-login.component';
import { MenuPaginaPrincipalComponent } from './menu-pagina-principal/menu-pagina-principal.component';
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path: '', redirectTo: 'login', pathMatch: 'full'},

  {path: 'login', component: CadastroLoginComponent},
  {path: 'menu-pagina-principal', component: MenuPaginaPrincipalComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
