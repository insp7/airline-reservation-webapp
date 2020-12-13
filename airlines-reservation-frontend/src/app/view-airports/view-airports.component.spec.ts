import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAirportsComponent } from './view-airports.component';

describe('ViewAirportsComponent', () => {
  let component: ViewAirportsComponent;
  let fixture: ComponentFixture<ViewAirportsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAirportsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAirportsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
