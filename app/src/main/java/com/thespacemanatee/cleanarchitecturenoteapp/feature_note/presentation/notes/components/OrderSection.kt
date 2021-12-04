package com.thespacemanatee.cleanarchitecturenoteapp.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thespacemanatee.cleanarchitecturenoteapp.feature_note.domain.util.NoteOrder
import com.thespacemanatee.cleanarchitecturenoteapp.feature_note.domain.util.OrderType
import com.thespacemanatee.cleanarchitecturenoteapp.R

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChanged: (NoteOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = stringResource(R.string.radio_title),
                selected = noteOrder is NoteOrder.Title,
                onSelect = { onOrderChanged(NoteOrder.Title(noteOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = stringResource(R.string.radio_date),
                selected = noteOrder is NoteOrder.Date,
                onSelect = { onOrderChanged(NoteOrder.Date(noteOrder.orderType)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = stringResource(R.string.radio_color),
                selected = noteOrder is NoteOrder.Color,
                onSelect = { onOrderChanged(NoteOrder.Color(noteOrder.orderType)) })
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = stringResource(R.string.radio_ascending),
                selected = noteOrder.orderType is OrderType.Ascending,
                onSelect = { onOrderChanged(noteOrder.copy(OrderType.Ascending)) })
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = stringResource(R.string.radio_descending),
                selected = noteOrder.orderType is OrderType.Descending,
                onSelect = { onOrderChanged(noteOrder.copy(OrderType.Descending)) })
        }
    }
}