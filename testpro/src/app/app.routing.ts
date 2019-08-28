import { RouterModule, Routes } from '@angular/router';
import { ModuleWithProviders } from '@angular/core/src/metadata/ng_module';
import { NewCmpComponent } from './new-cmp/new-cmp.component';

export const AppRoutes: Routes = [
    { path: '', component: NewCmpComponent }
];

export const ROUTING: ModuleWithProviders = RouterModule.forRoot(AppRoutes);